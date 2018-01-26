package com.mycompany.app.objects;

public class NonCatalogRequestObject {
	
	private int itemType;
	private String itemDescription;
	private String category;
	private int  quantity;
	private String unitOfMeasure;
	private int unitPrice;
	private int currency;
	private int  contractNumber;
	private boolean isRfqRequired; 
	private boolean isNegotiated; 
	private boolean isNewSupplier;
	private String contactName;
	private String phoneNumber;
	private String supplierItem;
	private String supplierName;
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	private String site; 
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getCurrency() {
		return currency;
	}
	public void setCurrency(int currency) {
		this.currency = currency;
	}
	public int getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}
	public boolean isRfqRequired() {
		return isRfqRequired;
	}
	public void setRfqRequired(boolean isRfqRequired) {
		this.isRfqRequired = isRfqRequired;
	}
	public boolean isNegotiated() {
		return isNegotiated;
	}
	public void setNegotiated(boolean isNegotiated) {
		this.isNegotiated = isNegotiated;
	}
	public boolean isNewSupplier() {
		return isNewSupplier;
	}
	public void setNewSupplier(boolean isNewSupplier) {
		this.isNewSupplier = isNewSupplier;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSupplierItem() {
		return supplierItem;
	}
	public void setSupplierItem(String supplierItem) {
		this.supplierItem = supplierItem;
	} 

	public void print()
	{
		System.out.println(this.itemType+"=="+this.itemDescription+"=="+this.category+"=="+this.quantity+"=="+this.unitOfMeasure+"=="+this.unitPrice+"=="+this.currency+"=="+this.isRfqRequired+"=="+this.isNegotiated+"=="+this.contractNumber+"=="+this.isNewSupplier+"=="+this.supplierName+"=="+this.site+"=="+this.contactName+"=="+this.phoneNumber+"=="+this.supplierItem);
	}
}