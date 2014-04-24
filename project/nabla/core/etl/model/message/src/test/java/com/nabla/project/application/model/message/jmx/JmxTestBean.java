package com.nabla.project.application.model.message.jmx;

public class JmxTestBean implements JmxTestBeanMBean
{
    private String name;
    private int    age;

    public int getAge()
    {
        return age;
    } // end getAge()

    public void setAge(final int age)
    {
        this.age = age;
    } // end setAge()

    public void setName(final String name)
    {
        this.name = name;
    } // end setName()

    public String getName()
    {
        return name;
    } // end getName()

    public int add(final int x, final int y)
    {
        return x + y;
    } // end add()

    public void dontExposeMe()
    {
        throw new RuntimeException();
    } // end dontExposeMe()
} // end JmxTestBean
