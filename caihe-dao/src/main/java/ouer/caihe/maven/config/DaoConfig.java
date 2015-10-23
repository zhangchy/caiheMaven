/**
 * 
 */
package ouer.caihe.maven.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.Resource;

/**
 * <pre>
 *
 * </pre>
 * 
 * @author Wayne.Wang<5waynewang@gmail.com>
 * @since 4:54:24 PM Jan 14, 2015
 */
@Configuration
@ImportResource("classpath:/META-INF/applicationContext-dao.xml")
public class DaoConfig {

    @Value("classpath:config/MapperConfig.xml")
    Resource   mybatisMapperConfig;

    @Autowired
    DataSource dataSource;

    <T> MapperFactoryBean<T> newMapperFactoryBean(Class<T> clazz) throws Exception {
        final MapperFactoryBean<T> b = new MapperFactoryBean<T>();
        b.setMapperInterface(clazz);
        b.setSqlSessionFactory(sqlSessionFactory());
        return b;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setConfigLocation(mybatisMapperConfig);
        fb.setDataSource(dataSource);
        // env.acceptsProfiles("prod") ? IdTypeHandler.class : IdTypeNullHandler.class
        return fb.getObject();
    }
    
}
