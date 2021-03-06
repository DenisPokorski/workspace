package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;

public class StockWatcher implements EntryPoint {
	private static final int REFRESH_INTERVAL = 5000; //ms
	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable stocksFlexTable = new FlexTable();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox newSymbolTextBox = new TextBox();
	private Button addStockButton = new Button("Add");
	private Label lastUpdatedLabel = new Label();
	private ArrayList<String> stocks = new ArrayList<String>();

	/**
	 * Entry point method.
	 */
	private void addStock() {
		final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
		newSymbolTextBox.setFocus(true);

		// aktien nicht hinzufügen die bereits drinnen sind
		if (stocks.contains(symbol))
			return;

		// Stock code must between 1 und 10 chars und zahlen..
		if (!symbol.matches("^[0-9A-Z&#92;&#92;.]{1,10}$")) {
			Window.alert("'" + symbol + "' kein gültiges Zeichen.");
			newSymbolTextBox.selectAll();
			return;
		}

		// aktien hinzugüen
		int row = stocksFlexTable.getRowCount();
		stocks.add(symbol);
		stocksFlexTable.setText(row, 0, symbol);
		stocksFlexTable.setWidget(row, 2, new Label());
		stocksFlexTable.getCellFormatter().addStyleName(row, 1, "watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(row, 2, "watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(row, 3, "watchListRemoveColumn");
		
		// Button hinzuügen um Aktien zu entfernen
		Button removeStockButton = new Button("x");
		removeStockButton.addStyleDependentName("remove");
		removeStockButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int removedIndex = stocks.indexOf(symbol);
				stocks.remove(removedIndex);
				stocksFlexTable.removeRow(removedIndex + 1);
			}
		});
		stocksFlexTable.setWidget(row, 3, removeStockButton);
	
		//Aktien preis
		refreshWatchList();
		
		
		
	}
	

	private void refreshWatchList() {
		// Fantasie Aktien Preise erstellen
		
			final double MAX_PRICE = 100.0; 
			final double MAX_PRICE_CHANGE = 0.02;
			
			StockPrice[] prices = new StockPrice[stocks.size()];
			for (int i=0; i < stocks.size(); i++) {
				double price = Random.nextDouble() * MAX_PRICE;
				double change = price* MAX_PRICE_CHANGE
						* (Random.nextDouble() * 2.0 - 1.0);
				
				prices[i] = new StockPrice(stocks.get(i), price, change)	;

			}
			
			updateTable(prices);
		}
		


// Preise aller aktien aktualisieren
	private void updateTable(StockPrice[] prices) {
		for (int i=0; i < prices.length; i++) {
			updateTable(prices[i]);
		}
	}

// einzelne zeile in der aktien tabelle aktualisieren
	private void updateTable(StockPrice price) {
		//Aktie immer noch in der Tabelle?
		if (!stocks.contains(price.getSymbol())) {
			return;
		}
		
		int row = stocks.indexOf(price.getSymbol()) + 1;
		
		//Daten im Preis und Change Feld formatieren
		String priceText = NumberFormat.getFormat("#,##0.00").format(
				price.getPrice());
		NumberFormat changeFormat = NumberFormat.getFormat("+#,##0.00;-#,##0.00");
		String changeText = changeFormat.format(price.getChange());
		String changePercentText = changeFormat.format(price.getChangePercent());
		
		//veröffentliche die daten felder
		stocksFlexTable.setText(row, 1, priceText);
		Label changeWidget = (Label)stocksFlexTable.getWidget(row, 2);
		changeWidget.setText(changeText + " (" + changePercentText + "%)");
		
		//Farben aufgrund rot grün veränderung ändern blalba
		String changeStyleName = "noChange";
		if (price.getChangePercent() < -0.1f) {
			changeStyleName = "negativeChange";
			
		}
		else if (price.getChangePercent() > 0.1f) {
			changeStyleName = "positiveChange";
		}
		
		changeWidget.setStyleName(changeStyleName);
	}


	public void onModuleLoad() {
		// TODO Create table for stock data.
		stocksFlexTable.setText(0, 0, "Symbol");
		stocksFlexTable.setText(0, 1, "Price");
		stocksFlexTable.setText(0, 2, "Change");
		stocksFlexTable.setText(0, 3, "Remove");
		
		  // Add styles to elements in the stock list table.
		  stocksFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
		  stocksFlexTable.addStyleName("watchList");
		  stocksFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
		  stocksFlexTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
		  stocksFlexTable.getCellFormatter().addStyleName(0, 3, "watchListRemoveColumn");
		  
		  //StyleElemente in die Aktie liste einfügne
		  stocksFlexTable.setCellPadding(6);

		  // Assemble the Add Stock panel
		  addPanel.add(newSymbolTextBox);
		  addPanel.add(addStockButton);
		  addPanel.addStyleName("addPanel");


		// TODO Assemble Add Stock panel.
		addPanel.add(newSymbolTextBox);
		addPanel.add(addStockButton);

		// TODO Assemble Main panel.
		mainPanel.add(stocksFlexTable);
		mainPanel.add(addPanel);
		mainPanel.add(lastUpdatedLabel);

		// TODO Associate the Main panel with the HTML host page.
		RootPanel.get("stockList").add(mainPanel);
		// TODO Move cursor focus to the input box.
		newSymbolTextBox.setFocus(true);

		// Listen for mouse events on the Add button.
		addStockButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addStock();
			}
		});

		// Listen for keyboard events in the input box.
		newSymbolTextBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					addStock();
				}
			}
		});
		
		//Mausfokus in inputbox?!
		newSymbolTextBox.setFocus(true);
		
		//Automatisches aktualisieren
		Timer refreshTimer = new Timer()	{
			@Override
			public void run() {
				refreshWatchList();
				
			}
		};
		refreshTimer.scheduleRepeating(REFRESH_INTERVAL);
	}

}
