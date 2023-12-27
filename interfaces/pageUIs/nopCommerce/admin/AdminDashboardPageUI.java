package pageUIs.nopCommerce.admin;

public class AdminDashboardPageUI {
	public static final String DASHBOARD_PAGE_TITLE_BY_TEXT = "xpath=//div[@class='content-header']/h1[contains(text(),'%s')]";
	public static final String MENU_TYPE_BY_TEXT = "xpath=//li[@class='nav-item has-treeview']/a/p[contains(text(),'%s')]";
	public static final String SUBMENU_TYPE_BY_MENU_TYPE_AND_TEXT = "xpath=//li[contains(@class,'nav-item has-treeview')]/a/p[contains(text(),'%s')]//parent::a//following-sibling::ul//p[contains(text(),'%s')]";

	public static final String PRODUCT_AREA_ICON_SERCH = "css=div.icon-search";
	public static final String PRODUCT_FAR_UP_ICON = "css=i.fa-angle-up";
	public static final String PRODUCT_NAME_TEXTBOX = "css=input#SearchProductName";
	public static final String PRODUCT_GO_DIRECTLY_TO_SKU_TEXTBOX = "css=input#GoDirectlyToSku";
	public static final String PRODUCT_SEARCH_BUTTON = "css=button#search-products";
	public static final String PRODUCT_GO_BUTTON = "css=button#go-to-product-by-sku";
	public static final String PRODUCT_NUMBER_GRID_INFOR = "css=div#products-grid_info";
	public static final String PRODUCT_NAME_BY_TEXT = "xpath=//td[contains(@class,'text-center')]//following-sibling::td[text()='%s']";
	public static final String PRODUCT_COLUM_INDEX_BY_NAME = "xpath=//table//th[@class='sorting_disabled' and text()='%s']//preceding-sibling::th";
	public static final String PRODUCT_TEXT_BY_PRODUCT_NAME_AND_COLUM_INDEX = "xpath=//td[contains(@class,'text-center')]//following-sibling::td[text()='%s']/parent::tr/td[%s]";
	public static final String PRODUCT_CHECK_PUBLIC_ICON_BY_PRODUCT_NAME = "xpath=//td[contains(@class,'text-center')]//following-sibling::td[text()='%s']/parent::tr/td[7]/i[@class='fas fa-check true-icon']";
	public static final String PRODUCT_DROPDOWN_BY_LABEL_NAME = "xpath=//label[@class='col-form-label' and text()='%s']//ancestor::div[@class='form-group row']//div/select";
	public static final String PRODUCT_SEARCH_SUBCATEGORIES_CHECKBOX = "css=input#SearchIncludeSubCategories";
	public static final String PRODUCT_MESSAGE_DATA_TABEL_BY_TEXT = "xpath=//td[@class='dataTables_empty' and text()='%s']";
	public static final String PRODUCT_HEADER_TITLE_BY_TEXT = "xpath=//div[contains(@class,'content-header')]/h1[contains(text(),'%s')]";

	public static final String CUSTOMER_ADD_NEW_BUTTON = "xpath=//a[@class='btn btn-primary' and contains(.,'Add new')]";
	public static final String CUSTOMER_TEXTBOX_BY_TEXT_LABEL = "xpath=//label[@class='col-form-label' and text()='%s']//ancestor::div[@class='form-group row']//div//input";
	public static final String CUSTOMER_DATEOFBIRTH_TEXTBOX = "css=input#DateOfBirth";
	public static final String CUSTOMER_GENDER_RADIO_BY_TEXT_LABEL = "xpath=//label[@class='form-check-label' and contains(text(),'%s')]//preceding-sibling::input";
	public static final String CUSTOMER_DROPDOWN_BY_TEXT_LABEL = "xpath=//label[@class='col-form-label' and text()='%s']//ancestor::div[@class='form-group row']//div/select";
	public static final String CUSTOMER_ROLE_PARENT_DROPDOWN = "xpath=//div[@class='input-group-append input-group-required']//div[@class='k-multiselect-wrap k-floatwrap']//input";
	public static final String CUSTOMER_ROLE_ITEM_IN_DROPDOWN = "xpath=//ul[@id='SelectedCustomerRoleIds_listbox']//li[text()='%s']";
	public static final String CUSTOMER_TAG_BY_TEXT = "xpath=//ul[@id='SelectedCustomerRoleIds_taglist']//span[text()='%s']";
	public static final String CUSTOMER_DELETE_ROLE_BUTTON_BY_TEXT = "xpath=//li[@class='k-button']/span[text()='%s']//following-sibling::span[@title='delete']";
	public static final String CUSTOMER_SAVE_AND_CONTINUE_EDIT_BUTTON = "name=save-continue";
	public static final String CUSTOMER_SAVE_BUTTON = "name=save";
	public static final String CUSTOMER_ADMIN_COMMENT_TEXTBOX = "css=textarea#AdminComment";
	public static final String CUSTOMER_SUCCESS_MESSAGE = "css=div.alert-success";
	public static final String BACK_TO_CUSTOMER_LIST_BUTTON = "xpath=//div[@class='content-header clearfix']//a[text()='back to customer list']";
	public static final String CUSTOMER_SEARCH_ROLE_PARENT_DROPDOWN = "xpath=//div[@class='col-md-8']//div[@class='k-multiselect-wrap k-floatwrap']//input";
	public static final String CUSTOMER_SEARCH_BUTTON = "css=button#search-customers";
	public static final String CUSTOMER_NAME_BY_TEXT = "xpath=//tbody/tr/td[text()='%s']";
	public static final String CUSTOMER_COLUM_INDEX_BY_NAME = "xpath=//table[contains(@class,'table-bordered')]//th[text()='%s']//preceding-sibling::th";
	public static final String CUSTOMER_TEXT_ITEM_BY_CUSTOMER_NAME_AND_COLUM_INDEX = "xpath=//table[contains(@class,'table-bordered')]//tbody//td[text()='%s']/parent::tr/td[%s]";
	public static final String CUSTOMER_NUMBER_GRID_INFOR = "css=div#customers-grid_info";
	public static final String CUSTOMER_DAY_DROPDOWN = "css=select#SearchDayOfBirth";
	public static final String CUSTOMER_MONTH_DROPDOWN = "css=select#SearchMonthOfBirth";
	public static final String CUSTOMER_EDIT_BUTTON_BY_NAME = "xpath=//table[contains(@class,'table-bordered')]//tbody//td[text()='%s']/parent::tr/td/a[@class='btn btn-default' and .='Edit']";
	public static final String CUSTOMER_AREA_ICON_MINUS_BY_TEXT = "xpath=//div[@class='card-title' and text()='%s']//following-sibling::div//i[@class='fa toggle-icon fa-minus']";
	public static final String CUSTOMER_AREA_TITLE_BY_TEXT = "xpath=//div[@class='card-title' and text()='%s']/parent::div";

	public static final String ADD_NEW_ADDRESS_BUTTON = "xpath=//button[contains(text(),'Add new address')]";
	public static final String ADDRESS_COUNTRY_DROPDOWN = "css=select#Address_CountryId";
	public static final String ADDRESS_TEXTBOX_BY_TEXT_LABEL = "xpath=//label[@class='col-form-label' and text()='%s']//ancestor::div[@class='form-group row']//div//input";
	public static final String ADDRESS_SAVE_BUTTON = "xpath=//button[contains(.,'Save')]";
	public static final String ADDRESS_COUNTRY_ITEM_SELECTED = "xpath=//select[@id='Address_CountryId']/option[@selected='selected']";
	public static final String BACK_TO_CUSTOMER_LIST_DETAILS_BUTTON = "xpath=//div[@class='content-header clearfix']//a[text()='back to customer details']";
	public static final String ADDRESS_GRID_EMAIL_BY_TEXT = "xpath=//td[text()='%s']";
	public static final String ADDRESS_COLUM_INDEX_BY_NAME = "xpath=//table[contains(@class,'table-bordered')]//th[text()='%s']//preceding-sibling::th";
	public static final String ADDRESS_TEXT_ITEM_BY_EMAIL_AND_COLUM_INDEX = "xpath=//table[contains(@class,'table-bordered')]//tbody//td[text()='%s']/parent::tr/td[%s]";
	public static final String ADDRESS_DELETE_BUTTON_BY_NAME = "xpath=//table[contains(@class,'table-bordered')]//tbody//td[text()='%s']/parent::tr/td/a[@class='btn btn-default' and .='Delete']";
	public static final String ADDRESS_MESSAGE_DATA_TABEL_BY_AREA_NAME_AND_TEXT = "xpath=//div[@class='card-title' and text()='%s']/parent::div//following-sibling::div[@class='card-body']//td[@class='dataTables_empty' and text()='%s']";

}
