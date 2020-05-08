package by.training.coffee.shop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    Page execute(HttpServletRequest request, HttpServletResponse response);
}