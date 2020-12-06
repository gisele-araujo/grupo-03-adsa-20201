module.exports = {
	development: {
	  dialect: "sqlite",
	  storage: "./db.development.sqlite"
	},
	test: {
	  dialect: "sqlite",
	  storage: ":memory:"
	},
	production: {
	  username: 'ProEagle-admin',
	  password: '#Gfgrupo3a',
	  database: 'PRO EAGLE',
	  host: 'proeagle-oficial.database.windows.net',
	  dialect: 'mssql',
	  xuse_env_variable: 'DATABASE_URL',
	  dialectOptions: {
		options: {
		  encrypt: true
		}
	  },
	  pool: { 
		max: 5,
		min: 1,
		acquire: 5000,
		idle: 30000,
		connectTimeout: 5000
	  }
	}
};
   
  