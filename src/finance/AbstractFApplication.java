package finance;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AbstractFApplication entity provides the base persistence definition of the
 * FApplication entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractFApplication implements java.io.Serializable
{

	// Fields

	private Integer applicationNo;
	private Date date;
	private String tno;
	private String transaction;
	private double cost;
	private String comment;
	private double officeSupplies;
	private double materialExpense;
	private double equipmentExpense;
	private double informationExpense;
	private double travellingExpense;
	private double entertainmentExpense;
	private double postExpense;
	private double printingExpense;
	private double pageExpense;
	private double communicationExpense;
	private double coferenceExpense;
	private double trainingExpense;
	private double porkingExpense;
	private double fuelExpense;
	private double unkeepExpense;
	private Integer number;

	// Constructors

	/** default constructor */
	public AbstractFApplication()
	{
	}

	/** full constructor */
	public AbstractFApplication(Date date, String tno, String transaction,
			double cost, String comment, double officeSupplies,
			double materialExpense, double equipmentExpense,
			double informationExpense, double travellingExpense,
			double entertainmentExpense, double postExpense,
			double printingExpense, double pageExpense,
			double communicationExpense, double coferenceExpense,
			double trainingExpense, double porkingExpense, double fuelExpense,
			double unkeepExpense, Integer number)
	{
		this.date = date;
		this.tno = tno;
		this.transaction = transaction;
		this.cost = cost;
		this.comment = comment;
		this.officeSupplies = officeSupplies;
		this.materialExpense = materialExpense;
		this.equipmentExpense = equipmentExpense;
		this.informationExpense = informationExpense;
		this.travellingExpense = travellingExpense;
		this.entertainmentExpense = entertainmentExpense;
		this.postExpense = postExpense;
		this.printingExpense = printingExpense;
		this.pageExpense = pageExpense;
		this.communicationExpense = communicationExpense;
		this.coferenceExpense = coferenceExpense;
		this.trainingExpense = trainingExpense;
		this.porkingExpense = porkingExpense;
		this.fuelExpense = fuelExpense;
		this.unkeepExpense = unkeepExpense;
		this.number = number;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ApplicationNo", unique = true, nullable = false)
	public Integer getApplicationNo()
	{
		return this.applicationNo;
	}

	public void setApplicationNo(Integer applicationNo)
	{
		this.applicationNo = applicationNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", length = 10)
	public Date getDate()
	{
		return this.date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	@Column(name = "Tno", length = 4)
	public String getTno()
	{
		return this.tno;
	}

	public void setTno(String tno)
	{
		this.tno = tno;
	}

	@Column(name = "Transaction", length = 50)
	public String getTransaction()
	{
		return this.transaction;
	}

	public void setTransaction(String transaction)
	{
		this.transaction = transaction;
	}

	@Column(name = "Cost", precision = 6)
	public double getCost()
	{
		return this.cost;
	}

	public void setCost(double cost)
	{
		this.cost = cost;
	}

	@Column(name = "Comment", length = 100)
	public String getComment()
	{
		return this.comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	@Column(name = "OfficeSupplies", precision = 6)
	public double getOfficeSupplies()
	{
		return this.officeSupplies;
	}

	public void setOfficeSupplies(double officeSupplies)
	{
		this.officeSupplies = officeSupplies;
	}

	@Column(name = "MaterialExpense", precision = 6)
	public double getMaterialExpense()
	{
		return this.materialExpense;
	}

	public void setMaterialExpense(double materialExpense)
	{
		this.materialExpense = materialExpense;
	}

	@Column(name = "EquipmentExpense", precision = 6)
	public double getEquipmentExpense()
	{
		return this.equipmentExpense;
	}

	public void setEquipmentExpense(double equipmentExpense)
	{
		this.equipmentExpense = equipmentExpense;
	}

	@Column(name = "InformationExpense", precision = 6)
	public double getInformationExpense()
	{
		return this.informationExpense;
	}

	public void setInformationExpense(double informationExpense)
	{
		this.informationExpense = informationExpense;
	}

	@Column(name = "TravellingExpense", precision = 6)
	public double getTravellingExpense()
	{
		return this.travellingExpense;
	}

	public void setTravellingExpense(double travellingExpense)
	{
		this.travellingExpense = travellingExpense;
	}

	@Column(name = "EntertainmentExpense", precision = 6)
	public double getEntertainmentExpense()
	{
		return this.entertainmentExpense;
	}

	public void setEntertainmentExpense(double entertainmentExpense)
	{
		this.entertainmentExpense = entertainmentExpense;
	}

	@Column(name = "PostExpense", precision = 6)
	public double getPostExpense()
	{
		return this.postExpense;
	}

	public void setPostExpense(double postExpense)
	{
		this.postExpense = postExpense;
	}

	@Column(name = "PrintingExpense", precision = 6)
	public double getPrintingExpense()
	{
		return this.printingExpense;
	}

	public void setPrintingExpense(double printingExpense)
	{
		this.printingExpense = printingExpense;
	}

	@Column(name = "PageExpense", precision = 6)
	public double getPageExpense()
	{
		return this.pageExpense;
	}

	public void setPageExpense(double pageExpense)
	{
		this.pageExpense = pageExpense;
	}

	@Column(name = "CommunicationExpense", precision = 6)
	public double getCommunicationExpense()
	{
		return this.communicationExpense;
	}

	public void setCommunicationExpense(double communicationExpense)
	{
		this.communicationExpense = communicationExpense;
	}

	@Column(name = "CoferenceExpense", precision = 6)
	public double getCoferenceExpense()
	{
		return this.coferenceExpense;
	}

	public void setCoferenceExpense(double coferenceExpense)
	{
		this.coferenceExpense = coferenceExpense;
	}

	@Column(name = "TrainingExpense", precision = 6)
	public double getTrainingExpense()
	{
		return this.trainingExpense;
	}

	public void setTrainingExpense(double trainingExpense)
	{
		this.trainingExpense = trainingExpense;
	}

	@Column(name = "PorkingExpense", precision = 6)
	public double getPorkingExpense()
	{
		return this.porkingExpense;
	}

	public void setPorkingExpense(double porkingExpense)
	{
		this.porkingExpense = porkingExpense;
	}

	@Column(name = "FuelExpense", precision = 6)
	public double getFuelExpense()
	{
		return this.fuelExpense;
	}

	public void setFuelExpense(double fuelExpense)
	{
		this.fuelExpense = fuelExpense;
	}

	@Column(name = "UnkeepExpense", precision = 6)
	public double getUnkeepExpense()
	{
		return this.unkeepExpense;
	}

	public void setUnkeepExpense(double unkeepExpense)
	{
		this.unkeepExpense = unkeepExpense;
	}

	@Column(name = "Number")
	public Integer getNumber()
	{
		return this.number;
	}

	public void setNumber(Integer number)
	{
		this.number = number;
	}

}