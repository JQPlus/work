package cn.bugging.work.entity;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

/**
 * @author HuangJq @Date 2019年5月2日下午5:18:03
 * @Description 总览页面实体
 * 
 */
public class OverviewEntity {
	/** 问题-当前状态ID */
	private String statusID;
	/** 问题-当前状态名 */
	private String statusName;
	/** 问题优先级ID */
	private String priorityID;
	/** 问题优先级名 */
	private String priorityName;
	/** 问题类型ID */
	private String typeID;
	/** 问题类型名 */
	private String typeName;
	/** 创建人 */
	private String creator;
	/** 所属人 */
	private String belongto;
	/** 创建时间 */
	private DateTime createtime;
	/** 更新时间 */
	private DateTime updatetime;

	public String getStatusID() {
		return statusID;
	}

	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getPriorityID() {
		return priorityID;
	}

	public void setPriorityID(String priorityID) {
		this.priorityID = priorityID;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getBelongto() {
		return belongto;
	}

	public void setBelongto(String belongto) {
		this.belongto = belongto;
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

}
