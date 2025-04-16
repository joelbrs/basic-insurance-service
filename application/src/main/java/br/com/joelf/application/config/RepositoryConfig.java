package br.com.joelf.application.config;

import br.com.joelf.application.infrastructure.cache.RedisRepository;
import br.com.joelf.application.infrastructure.database.JdbiCarRepository;
import br.com.joelf.application.infrastructure.database.JdbiClaimRepository;
import br.com.joelf.domain.port.CacheRepository;
import br.com.joelf.domain.port.CarRepository;
import br.com.joelf.domain.port.ClaimRepository;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class RepositoryConfig {

    @Bean
    public Jdbi jdbi(DataSource ds, List<JdbiPlugin> jdbiPlugins, List<RowMapper<?>> rowMappers) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(ds);
        Jdbi jdbi = Jdbi.create(proxy);

        jdbiPlugins.forEach(jdbi::installPlugin);
        rowMappers.forEach(jdbi::registerRowMapper);

        return jdbi;
    }

    @Bean
    public JdbiPlugin jdbiPlugin() {
        return new SqlObjectPlugin();
    }

    @Bean
    public <V> RedisTemplate<String, V> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, V> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return template;
    }

    @Bean
    public <V> CacheRepository<String, V> cacheRepository(
            RedisTemplate<String, V> redisTemplate,
            @Value("${app.redis.time-to-live}") String timeToLive
    ) {
        return new RedisRepository<>(redisTemplate, timeToLive);
    }

    @Bean
    public ClaimRepository claimRepository(Jdbi jdbi) {
        return jdbi.onDemand(JdbiClaimRepository.class);
    }

    @Bean
    public CarRepository carRepository(Jdbi jdbi) {
        return jdbi.onDemand(JdbiCarRepository.class);
    }
}
