/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.damsolutions.mda.metamodel;

/**
 *
 * @author kmejia
 */
public class Property {


    private String id;
    private String name;
    private String title;
    private String label;
    private String instruction;
    private String description;
    private Integer lenght;
	private Integer width;
	private Integer minimum;
	private Integer maximum;
    private Integer order;
    private boolean nillable;
	private boolean sortable;
    private boolean required;
    private boolean  finding;
    private boolean visible;
    private DataType dataType;
    private RegularExpression regularExpression;
    private Entity entity;


    public Integer getLenght() {
		return lenght;
	}

	public void setLenght(Integer lenght) {
		this.lenght = lenght;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Property(){}
    
    public Property(String id) {
		super();
		this.id = id;
	}

	public Property(String id
    ,String name
    ,String title
    ,String description
    ,Integer lentght
    ,boolean required
    ,Integer order
    ,DataType dataType
    ,RegularExpression regularExpression){
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.lenght = lenght;
        this.order = order;
        this.dataType = dataType;
        this.regularExpression = regularExpression;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * @return the dataType
     */
    public DataType getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the regularExpression
     */
    public RegularExpression getRegularExpression() {
        return regularExpression;
    }

    /**
     * @param regularExpression the regularExpression to set
     */
    public void setRegularExpression(RegularExpression regularExpression) {
        this.regularExpression = regularExpression;
    }

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isNillable() {
		return nillable;
	}

	public void setNillable(boolean nillable) {
		this.nillable = nillable;
	}

	public boolean isSortable() {
		return sortable;
	}

	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isFinding() {
		return finding;
	}

	public void setFinding(boolean finding) {
		this.finding = finding;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

}
