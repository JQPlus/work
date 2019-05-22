package cn.bugging.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.bugging.work.entity.UserEntity;

public interface OverviewDao {

	/**
	 * 
	 * @return 我创建的问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE creator=#{creator}")
	int getMyCreateNum(String creator);

	/**
	 * 
	 * @return 指派给我的问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto}")
	int getBelongtoMeNum(String belongto);

	/**
	 * 
	 * @return 待我解决的问题数目(所属人为自己，状态!=已拒绝和已验收)
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto} AND status_id!=4 AND status_id!=5")
	int getMyHandlingNum(String belongto);

	/**
	 * 
	 * @return 我跟踪的问题数目(创建人或者所属人为自己的问题，并且问题状态！=已拒绝和已验收)
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE creator=#{creator} OR belongto=#{belongto} AND status_id!=4 AND status_id!=5")
	int getMyTraceNum(String creator,String belongto);
	
	/**
	 * 
	 * @return 我解决的问题数目(所属人为自己的问题，并且问题状态=已解决)
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto} AND status_id=3")
	int getMySolvedNum(String belongto);

	/**
	 * 
	 * @return 我拒绝问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto} AND status_id=4")
	int getAMyRefusedNum(String belongto);

	/**
	 * 
	 * @return 我被验收问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto} AND status_id=5")
	int getMyCheckedNum(String belongto);

	/**
	 * 
	 * @return 我延期问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE belongto=#{belongto} AND status_id=6")
	int getMyDelayedNum(String belongto);
	
	
	/**
	 * 
	 * @return 所有未关闭的问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id!=4 AND status_id!=5")
	int getAllUnclosedNum();

	/**
	 * @return 所有新建问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=1")
	int getAllNewCreateNum();

	/**
	 * 
	 * @return 所有处理中问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=2")
	int getAllHandlingNum();

	/**
	 * 
	 * @return 所有已解决问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=3")
	int getAllSolvedNum();

	/**
	 * 
	 * @return 所有已拒绝问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=4")
	int getAllRefusedNum();

	/**
	 * 
	 * @return 所有已验收问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=5")
	int getAllCheckedNum();

	/**
	 * 
	 * @return 所有延期问题数目
	 */
	@Select("SELECT COUNT(*) FROM bug_detail WHERE status_id=6")
	int getAllDelayedNum();
	
	/**
	 * 
	 * @param user
	 * @return 
	 * @Description 新增成员
	 */
	@Insert("INSERT INTO user (id,username,password)  VALUES (#{ID,jdbcType=VARCHAR},#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR})")
	boolean addUser(UserEntity user);
	
	/**
	 * 
	 * @return 
	 * @Description 用户用户列表
	 */
	@Select("SELECT * FROM user")
	List<UserEntity> getUser();

}
