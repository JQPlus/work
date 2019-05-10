package cn.bugging.work.utils.consts;

/**
 * @author HuangJq
 * @Description 问题状态字符串
 * 
 */
public class Status {

	/** 问题状态->新建 */
	public static final String CREATE = "新建";
	/** 问题状态->处理中 */
	public static final String HANDLE = "处理中";
	/** 问题状态->已解决 */
	public static final String SOLVED = "已解决";
	/** 问题状态->已拒绝 */
	public static final String REFUSE = "已拒绝";
	/** 问题状态->已验收 */
	public static final String CHECKE = "已验收";
	/** 问题状态->延期 */
	public static final String DELAY = "延期";

	/** 统计状态->我创建的 */
	public static final String CREATE_BY_ME = "我创建的";
	/** 统计状态->待我解决 */
	public static final String HANDLE_BY_ME = "待我解决";
	/** 统计状态->我追踪的 */
	public static final String TRACE_BY_ME = "我追踪的";
	/** 统计状态->指派给我的 */
	public static final String BELONG_TO_ME = "指派给我的";
}
