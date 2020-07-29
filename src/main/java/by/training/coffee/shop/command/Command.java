package by.training.coffee.shop.command;

import by.training.coffee.shop.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}