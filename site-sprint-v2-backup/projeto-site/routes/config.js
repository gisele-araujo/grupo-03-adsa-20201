var sql = require('mssql');

let dbConfig = {
	server: 'proeagle-oficial.database.windows.net',
	user: 'ProEagle-admin',
	password: '#Gfgrupo3a',
	database: 'PRO EAGLE',
	"options": {
		"encrypt": true,
		"enableArithAbort": true
	}
}

let connection = new sql.ConnectionPool(dbConfig);

connection.connect((err) => {
	if (err) throw err;
	console.log('Conexão estabelecida!')
})

module.exports = connection;