// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package org.andromda.test.howto16.a;

/**
 * @see Car
 */
public class CarDaoImpl extends CarDaoBase
{
    /**
     * @see org.andromda.test.howto16.a.CarDao#allCarsAreRented()
     */
    protected boolean handleAllCarsAreRented()
    {
        // TODO implement public boolean handleAllCarsAreRented()
        return false;
    }

    /**
     * @see org.andromda.test.howto16.a.CarDao#toCarVo(Car, CareValueObject)
     */
    public void toCarVo(Car sourceEntity, CareValueObject targetVO)
    {
        // TODO verify behavior of toCarVo
        super.toCarVo(sourceEntity, targetVO);
    }

    /**
     * @see org.andromda.test.howto16.a.CarDao#toCarVo(Car)
     */
    public CareValueObject toCarVo(final Car entity)
    {
        // TODO verify behavior of toCarVo
        return super.toCarVo(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private Car loadCarFromCareValueObject(CareValueObject carVo)
    {
        // TODO implement loadCarFromCareValueObject
        throw new UnsupportedOperationException("org.andromda.test.howto16.a.loadCarFromCareValueObject(CareValueObject) not yet implemented.");

        /*
         * A typical implementation looks like this:
         * Car car = this.load(carVo.getId());
         * if (car == null)
         * {
         * car = Car.Factory.newInstance();
         * }
         * return car;
         */
    }

    /**
     * @see org.andromda.test.howto16.a.CarDao#carVoToEntity(CareValueObject)
     */
    public Car carVoToEntity(CareValueObject carVo)
    {
        // TODO verify behavior of carVoToEntity
        Car entity = this.loadCarFromCareValueObject(carVo);
        this.carVoToEntity(carVo, entity, true);
        return entity;
    }

    /**
     * @see org.andromda.test.howto16.a.CarDao#carVoToEntity(CareValueObject, Car)
     */
    public void carVoToEntity(CareValueObject sourceVO, Car targetEntity, boolean copyIfNull)
    {
        // TODO verify behavior of carVoToEntity
        super.carVoToEntity(sourceVO, targetEntity, copyIfNull);
    }

}
