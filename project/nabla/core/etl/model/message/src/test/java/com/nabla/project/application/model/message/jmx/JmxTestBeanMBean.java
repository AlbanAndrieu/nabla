package com.nabla.project.application.model.message.jmx;

public interface JmxTestBeanMBean
{
    public int add(final int x, final int y);

    public int getAge();

    public void setAge(final int age);

    public void setName(final String name);

    public String getName();
} // end JmxTestBeanMBean
