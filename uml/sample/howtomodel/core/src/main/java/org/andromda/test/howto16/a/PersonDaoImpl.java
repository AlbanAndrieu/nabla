// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package org.andromda.test.howto16.a;

/**
 * @see Person
 */
public class PersonDaoImpl extends PersonDaoBase
{
    /**
     * @see org.andromda.test.howto16.a.PersonDao#toPersonValueObject(Person, PersonValueObject)
     */
    public void toPersonValueObject(Person sourceEntity, PersonValueObject targetVO)
    {
        // TODO verify behavior of toPersonValueObject
        super.toPersonValueObject(sourceEntity, targetVO);
    }

    /**
     * @see org.andromda.test.howto16.a.PersonDao#toPersonValueObject(Person)
     */
    public PersonValueObject toPersonValueObject(final Person entity)
    {
        // TODO verify behavior of toPersonValueObject
        return super.toPersonValueObject(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private Person loadPersonFromPersonValueObject(PersonValueObject personValueObject)
    {
        // TODO implement loadPersonFromPersonValueObject
        throw new UnsupportedOperationException("org.andromda.test.howto16.a.loadPersonFromPersonValueObject(PersonValueObject) not yet implemented.");

        /*
         * A typical implementation looks like this:
         * Person person = this.load(personValueObject.getId());
         * if (person == null)
         * {
         * person = Person.Factory.newInstance();
         * }
         * return person;
         */
    }

    /**
     * @see org.andromda.test.howto16.a.PersonDao#personValueObjectToEntity(PersonValueObject)
     */
    public Person personValueObjectToEntity(PersonValueObject personValueObject)
    {
        // TODO verify behavior of personValueObjectToEntity
        Person entity = this.loadPersonFromPersonValueObject(personValueObject);
        this.personValueObjectToEntity(personValueObject, entity, true);
        return entity;
    }

    /**
     * @see org.andromda.test.howto16.a.PersonDao#personValueObjectToEntity(PersonValueObject, Person)
     */
    public void personValueObjectToEntity(PersonValueObject sourceVO, Person targetEntity, boolean copyIfNull)
    {
        // TODO verify behavior of personValueObjectToEntity
        super.personValueObjectToEntity(sourceVO, targetEntity, copyIfNull);
    }

}
