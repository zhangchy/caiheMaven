package ouer.caihe.maven.auth.model;

public class Resource {
	private String id;
	private String resourceName;
	private Boolean isMenu;
	private String parentId;
	private String url;
	private Integer order = new Integer(0);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Boolean getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Boolean isMenu) {
		this.isMenu = isMenu;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
}
