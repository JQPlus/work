package cn.bugging.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.bugging.work.entity.HistoryEntity;

public interface HistoryDao {

	@Select("SELECT * FROM history ORDER BY updatetime DESC")
	@Results(@Result(column = "bug_num", property = "num"))
	public List<HistoryEntity> getHistoryList();

	/**
	 * 
	 * @param detail
	 * @return
	 * @Description 新增bug信息
	 */
	@Insert("INSERT INTO history"
			+ "(id,bug_id,bug_num,type_id,status_id,priority_id,brief,createtime,updatetime,creator,belongto,updater,remark) "
			+ "VALUES"
			+ "(#{ID,jdbcType=VARCHAR},#{bugID,jdbcType=VARCHAR},#{num,jdbcType=INTEGER},#{typeID,jdbcType=VARCHAR}, #{statusID,jdbcType=VARCHAR},"
			+ "#{priorityID,jdbcType=VARCHAR},#{brief,jdbcType=VARCHAR} ,#{createtime,jdbcType=TIMESTAMP},"
			+ "#{updatetime,jdbcType=TIMESTAMP},#{creator,jdbcType=VARCHAR}, #{belongto,jdbcType=VARCHAR},#{updater,jdbcType=VARCHAR},#{remark,jdbcType=VARCHAR})")
	boolean insert(HistoryEntity history);
}
