package finance;

import java.util.Date;

public class Approval
{
	private String ApprovalNo;
	private String ApplicationNo;
	private String Date;
	private String Approver;
	private String Comment;
	public String getApprovalNo()
	{
		return ApprovalNo;
	}
	public void setApprovalNo(String approvalNo)
	{
		ApprovalNo = approvalNo;
	}
	public String getApplicationNo()
	{
		return ApplicationNo;
	}
	public void setApplicationNo(String applicationNo)
	{
		ApplicationNo = applicationNo;
	}
	public String getApprover()
	{
		return Approver;
	}
	public void setApprover(String approver)
	{
		Approver = approver;
	}
	public String getComment()
	{
		return Comment;
	}
	public void setComment(String comment)
	{
		Comment = comment;
	}
	public String getDate()
	{
		return Date;
	}
	public void setDate(String date)
	{
		Date = date;
	}
}
