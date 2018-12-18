package core.polimorfismo.classes.poi;

public enum TipoDestino {

	BANCO {

		@Override
		public GenericDAO DAOFactory() {

			return new DatabaseDAOImpl();
		}

	},
	Arquivo {

		@Override
		public GenericDAO DAOFactory() {
			return new ArquivoDAOImpl();
		}

	};

	public abstract GenericDAO DAOFactory();

}
