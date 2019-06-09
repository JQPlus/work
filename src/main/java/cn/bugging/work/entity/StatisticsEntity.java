package cn.bugging.work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

@Entity
public class StatisticsEntity {
	/**
	 * @author HuangJq @Date 2019年5月2日下午5:18:30
	 * @Description
	 * 
	 */
	private String statusName;
	private String typeName;
	private String priorityName;

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

}
