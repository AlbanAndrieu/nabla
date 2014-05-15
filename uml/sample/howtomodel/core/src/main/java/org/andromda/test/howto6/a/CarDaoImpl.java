// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package org.andromda.test.howto6.a;

/**
 * @see Car
 */
public class CarDaoImpl extends CarDaoBase
{
    /**
     * @see org.andromda.test.howto6.a.CarDao#allCarsAreRented()
     */
    protected boolean handleAllCarsAreRented()
    {
        // TODO implement public boolean handleAllCarsAreRented()
        return false;
    }

    /**
     * @see org.andromda.test.howto6.a.CarDao#toCarDetails(Car, CarDetails)
     */
    public void toCarDetails(Car sourceEntity, CarDetails targetVO)
    {
        // TODO verify behavior of toCarDetails
        super.toCarDetails(sourceEntity, targetVO);
    }

    /**
     * @see org.andromda.test.howto6.a.CarDao#toCarDetails(Car)
     */
    public CarDetails toCarDetails(final Car entity)
    {
        // TODO verify behavior of toCarDetails
        return super.toCarDetails(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private Car loadCarFromCarDetails(CarDetails carDetails)
    {
        // TODO implement loadCarFromCarDetails
        throw new UnsupportedOperationException("org.andromda.test.howto6.a.loadCarFromCarDetails(CarDetails) not yet implemented.");

        /*
         * A typical implementation looks like this:
         * Car car = this.load(carDetails.getId());
         * if (car == null)
         * {
         * car = Car.Factory.newInstance();
         * }
         * return car;
         */
    }

    /**
     * @see org.andromda.test.howto6.a.CarDao#carDetailsToEntity(CarDetails)
     */
    public Car carDetailsToEntity(CarDetails carDetails)
    {
        // TODO verify behavior of carDetailsToEntity
        Car entity = this.loadCarFromCarDetails(carDetails);
        this.carDetailsToEntity(carDetails, entity, true);
        return entity;
    }

    /**
     * @see org.andromda.test.howto6.a.CarDao#carDetailsToEntity(CarDetails, Car)
     */
    public void carDetailsToEntity(CarDetails sourceVO, Car targetEntity, boolean copyIfNull)
    {
        // TODO verify behavior of carDetailsToEntity
        super.carDetailsToEntity(sourceVO, targetEntity, copyIfNull);
    }

    /**
     * @see org.andromda.test.howto6.a.CarDao#toCarListItem(Car, CarListItem)
     */
    public void toCarListItem(Car sourceEntity, CarListItem targetVO)
    {
        // TODO verify behavior of toCarListItem
        super.toCarListItem(sourceEntity, targetVO);
    }

    /**
     * @see org.andromda.test.howto6.a.CarDao#toCarListItem(Car)
     */
    public CarListItem toCarListItem(final Car entity)
    {
        // TODO verify behavior of toCarListItem
        return super.toCarListItem(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private Car loadCarFromCarListItem(CarListItem carListItem)
    {
        // TODO implement loadCarFromCarListItem
        throw new UnsupportedOperationException("org.andromda.test.howto6.a.loadCarFromCarListItem(CarListItem) not yet implemented.");

        /*
         * A typical implementation looks like this:
         * Car car = this.load(carListItem.getId());
         * if (car == null)
         * {
         * car = Car.Factory.newInstance();
         * }
         * return car;
         */
    }

    /**
     * @see org.andromda.test.howto6.a.CarDao#carListItemToEntity(CarListItem)
     */
    public Car carListItemToEntity(CarListItem carListItem)
    {
        // TODO verify behavior of carListItemToEntity
        Car entity = this.loadCarFromCarListItem(carListItem);
        this.carListItemToEntity(carListItem, entity, true);
        return entity;
    }

    /**
     * @see org.andromda.test.howto6.a.CarDao#carListItemToEntity(CarListItem, Car)
     */
    public void carListItemToEntity(CarListItem sourceVO, Car targetEntity, boolean copyIfNull)
    {
        // TODO verify behavior of carListItemToEntity
        super.carListItemToEntity(sourceVO, targetEntity, copyIfNull);
    }

}
