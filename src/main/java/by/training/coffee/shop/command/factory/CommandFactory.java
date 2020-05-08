package by.training.coffee.shop.command.factory;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.CommandType;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    public Command getCommand(HttpServletRequest request) {
        String commandName = request.getParameter("command");

        CommandType commandType = new CommandType();

        return commandType.getCommand(commandName);
    }
}
