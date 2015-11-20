package ouer.caihe.maven.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ouer.caihe.maven.auth.model.Resource;
import ouer.caihe.maven.mapper.auth.ResourceMapper;
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private ResourceMapper resourceMapper;
	@Override
	public List<Resource> getAllResourcesUrlNotNull() {
		return resourceMapper.selectAllResourcesUrlNotNull();
	}

}
