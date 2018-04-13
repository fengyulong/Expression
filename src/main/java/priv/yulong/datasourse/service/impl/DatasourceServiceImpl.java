package priv.yulong.datasourse.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import priv.yulong.datasourse.mapper.DatasourceMapper;
import priv.yulong.datasourse.model.Datasource;
import priv.yulong.datasourse.service.DatasourceService;

@Service
@Transactional
public class DatasourceServiceImpl implements DatasourceService {

	@Resource
	private DatasourceMapper datasourceMapper;

	@Override
	@Cacheable(value = "datasource", key = "#datasourceCode")
	public Datasource getDataSource(String datasourceCode) {
		return datasourceMapper.selectByDatasourceCode(datasourceCode);
	}

	@Override
	@CachePut(value = "datasource", key = "#datasource.code")
	public Datasource addDatasource(Datasource datasource) {
		datasourceMapper.insert(datasource);
		return datasource;
	}

	@Override
	@CachePut(value = "datasource", key = "#datasource.code")
	public Datasource updateDatasource(Datasource datasource) {
		datasourceMapper.updateByPrimaryKey(datasource);
		return datasource;
	}

	@Override
	@CacheEvict(value = "datasource", key = "#datasource.code")
	public void deleteDatasource(Datasource datasource) {
		datasourceMapper.deleteByPrimaryKey(datasource.getId());
	}

}
