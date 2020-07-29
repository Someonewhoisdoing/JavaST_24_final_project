package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.AddressDAO;
import by.training.coffee.shop.entity.Address;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.Service;



public class AddressService implements Service<Address> {

    private AddressDAO addressDAO = new AddressDAO();

    @Override
    public boolean create(Address entity) throws DAOException, ServiceException {
        try {
            return addressDAO.create(entity,true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }

    public boolean updateAddress(Address entity) throws ServiceException {
        try {
            return addressDAO.updateAddress(entity,true);
        } catch ( DAOException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }
}
