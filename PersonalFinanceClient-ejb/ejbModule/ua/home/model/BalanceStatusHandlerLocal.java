package ua.home.model;

import java.util.List;

import javax.ejb.Local;

import ua.home.entity.Balancestatus;

@Local
public interface BalanceStatusHandlerLocal {

	Balancestatus getStatusByName(String status);
}
