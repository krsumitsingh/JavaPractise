package pkgTestBase;

public class Config_PO extends TestBase {

	public String getVendorName() {
		return repo.getProperty("vendor_name");
	}

	public String getvendorcontact() {
		return repo.getProperty("vendor_contact");
	}

	public String getSelectOrderBy() {
		return repo.getProperty("order_by");

	}
	
	public String getSelectLicensee() {
		return repo.getProperty("company");

	}
		
	public String getProjectName(){
		return repo.getProperty("projectname");
	}
	
	
	public String getItemDropDown(){
		return repo.getProperty("ItemDropDown");
	}
	
	public String getQuantity(){
		return repo.getProperty("Quantity");
	}
	
	public String getMarkUpTxt(){
		return repo.getProperty("MarkUpTxt");
	}
	
	public String getUnitPriceTxt(){
		return repo.getProperty("UnitPriceTxt");
	}
	
	public String getExtPrice(){
		return repo.getProperty("ExtendedPriceTotal");
	}	
		
    public String getExtPriceAndMarkup(){
			return repo.getProperty("ExtendedPriceTotalandMarkUp");
	}
	
}
