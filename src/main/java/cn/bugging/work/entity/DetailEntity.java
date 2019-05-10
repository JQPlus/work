package cn.bugging.work.entity;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

/**
 * @author HuangJq @Date 2019年5月2日下午5:17:25
 * @Description
 * 
 */
public class DetailEntity {

	/** 问题ID */
	private String ID;
	/** 类别ID */
	private String categoryID;
	/** 问题状态ID */
	private String statusID;
	/** 问题优先级ID */
	private String priorityID;
	/** 问题简述 */
	private String brief;
	/** 创建时间 */
	private DateTime createtime;
	/** 更新时间 */
	private DateTime updatetime;
	/** 创建人 */
	private String creator;
	/** 所属人 */
	private String belongto;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getStatusID() {
		return statusID;
	}

	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}

	public String getLevelID() {
		return priorityID;
	}

	public void setLevelID(String priorityID) {
		this.priorityID = priorityID;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public DateTime getCreatetime() {
		return createtime;
	}

	public void setCreatetime(DateTime createtime) {
		this.createtime = createtime;
	}

	public DateTime getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(DateTime updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreater() {
		return creator;
	}

	public void setCreater(String creator) {
		this.creator = creator;
	}

	public String getBelongto() {
		return belongto;
	}

	public void setBelongto(String belongto) {
		this.belongto = belongto;
	}
}
