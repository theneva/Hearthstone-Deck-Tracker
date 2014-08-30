package model;

public class Card
{
    private int set;
    private int quality;
    private int type;
    private int cost;
    private int health;
    private int attack;
    private int faction;
    private int classs;
    private int elite;
    private String name;
    private String description;
    private String createdAt;
    private String updatedAt;
    private int id;

    public int getSet()
    {
        return set;
    }

    public void setSet(final int set)
    {
        this.set = set;
    }

    public int getQuality()
    {
        return quality;
    }

    public void setQuality(final int quality)
    {
        this.quality = quality;
    }

    public int getType()
    {
        return type;
    }

    public void setType(final int type)
    {
        this.type = type;
    }

    public int getCost()
    {
        return cost;
    }

    public void setCost(final int cost)
    {
        this.cost = cost;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(final int health)
    {
        this.health = health;
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(final int attack)
    {
        this.attack = attack;
    }

    public int getFaction()
    {
        return faction;
    }

    public void setFaction(final int faction)
    {
        this.faction = faction;
    }

    public int getClasss()
    {
        return classs;
    }

    public void setClasss(final int classs)
    {
        this.classs = classs;
    }

    public int getElite()
    {
        return elite;
    }

    public void setElite(final int elite)
    {
        this.elite = elite;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public String getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(final String createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(final String updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public int getId()
    {
        return id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Card{" +
                "set=" + set +
                ", quality=" + quality +
                ", type=" + type +
                ", cost=" + cost +
                ", health=" + health +
                ", attack=" + attack +
                ", faction=" + faction +
                ", classs=" + classs +
                ", elite=" + elite +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", id=" + id +
                '}';
    }
}
