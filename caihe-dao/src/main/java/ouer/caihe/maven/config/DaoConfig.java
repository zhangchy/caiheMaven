package ouer.caihe.maven.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.Resource;

import ouer.caihe.maven.Scanned;
import ouer.caihe.maven.mapper.auth.GroupMapper;
import ouer.caihe.maven.mapper.auth.GroupRoleMapper;
import ouer.caihe.maven.mapper.auth.GroupUserMapper;
import ouer.caihe.maven.mapper.auth.ResourceMapper;
import ouer.caihe.maven.mapper.auth.ResourceRoleMapper;
import ouer.caihe.maven.mapper.auth.RoleMapper;
import ouer.caihe.maven.mapper.auth.UserMapper;
import ouer.caihe.maven.mapper.auth.UserRoleMapper;

/**
 * <pre>
 *
 * </pre>
 * 
 * @author Wayne.Wang<5waynewang@gmail.com>
 * @since 4:54:24 PM Jan 14, 2015
 */
@Configuration
@ComponentScan(basePackageClasses = Scanned.class)
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
        fb.setTypeAliases(new Class<?>[] { IdTypeHandler.class});
        return fb.getObject();
    }
    
    @Bean
    public GroupMapper groupMapper() throws Exception {
        return newMapperFactoryBean(GroupMapper.class).getObject();
    }
    
    @Bean
    public GroupRoleMapper groupRoleMapper() throws Exception {
        return newMapperFactoryBean(GroupRoleMapper.class).getObject();
    }
    
    @Bean
    public GroupUserMapper groupUserMapper() throws Exception {
        return newMapperFactoryBean(GroupUserMapper.class).getObject();
    }
    
    @Bean
    public UserMapper userMapper() throws Exception {
        return newMapperFactoryBean(UserMapper.class).getObject();
    }
    
    @Bean
    public RoleMapper roleMapper() throws Exception {
        return newMapperFactoryBean(RoleMapper.class).getObject();
    }
    
    @Bean
    public ResourceMapper resourceMapper() throws Exception {
        return newMapperFactoryBean(ResourceMapper.class).getObject();
    }
    
    @Bean
    public ResourceRoleMapper resourceRoleMapper() throws Exception {
        return newMapperFactoryBean(ResourceRoleMapper.class).getObject();
    }
    
    @Bean
    public UserRoleMapper userRoleMapper() throws Exception {
        return newMapperFactoryBean(UserRoleMapper.class).getObject();
    }
}
