Концепциски архитектурен дизајн ги опфаќа целокупно компонентите и конекторите со одговорностите на ниво на доменот.


Концепцискиот архитектурен дизајн на "Твој Маркет" се состои од следните функции:
Component responsibilities:

AppUI
	ShowMarketsLocation - функцијата ќе овозможува приказ на локациите на корисничкиот интерфејс
	ShowMarketsInfo - функицјата ќе ги прикажува информациите за секој од маркетите на корисничкиот интерфејс
	DisplayMap - функцијата ќе овозможи приказ на маркетите на мапа во корисничкиот интерфејс
	
AdminPanel
	ListMarkets - ќе ги листа сите маркети
	ListConnections 

MapService
	GetMarketLocation - овозможува пристап до локацијата на секој од маркетите
	GetMarketInfo - овозможува пристап до информациите за секој од маркетите
	GetMap - овозможува пристап до мапата со секој од маркетите

AdminService
	AddMarket - додавање на нов маркет во базата
	RemoveMarket - бришење на маркет од базата

LocationFinder
	LocateMarket - лоцирање на секој од маркетите

MarketInfo
	MarketWorkingHours - работно време на маркетот
	MarketLocation - локацијата на маркетот
	MarketContact - податоци за контакт со маркетот
		MarketWebPage
		MarketPhoneNumber
		MarketEmail
	ListAvailableMarkets - листање на сите отворени маркети во даден момент	

UserManager
	RegisterUser - регистрација на нов корисник
	LoginUser - најава на постоечки корисник

GeoinformaionManager
	AddMarket - додавање на нов маркет 
	RemoveMarket - бришење на маркет 
	SearchMarket - пребарување на маркет
	