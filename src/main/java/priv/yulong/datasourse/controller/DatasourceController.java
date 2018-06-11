package priv.yulong.datasourse.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import priv.yulong.common.model.DataGridModel;
import priv.yulong.datasourse.model.Datasource;
import priv.yulong.datasourse.service.DatasourceService;

@Controller
@RequestMapping(value = "/datasource")
public class DatasourceController {

	@Resource
	private DatasourceService datasourceService;

	/**
	 * 数据源管理-列表页面
	 * 
	 * @return
	 */
	@RequiresPermissions(value = { "datasource:list" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "datasource/list";
	}

	@ResponseBody
	@RequiresPermissions(value = { "datasource:list" })
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String list(String sort, String order) {
		List<Datasource> datasourceList = datasourceService.getAll();
		DataGridModel<Datasource> grid = new DataGridModel<Datasource>();
		grid.setRows(datasourceList);
		return JSON.toJSONString(grid);
	}

	/**
	 * 数据源管理-新增数据
	 * 
	 * @param datasource
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions(value = { "datasource:add" })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Datasource datasource) {
		datasourceService.addDatasource(datasource);
		return "success";
	}

	/**
	 * 数据源管理-编辑数据
	 * 
	 * @param datasource
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions(value = { "datasource:edit" })
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Datasource datasource) {
		datasourceService.updateDatasource(datasource);
		return "success";
	}

	/**
	 * 数据源管理-删除数据
	 * @param datasource
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions(value = { "datasource:delete" })
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Datasource datasource) {
		datasourceService.deleteDatasource(datasource);
		return "success";
	}

}
