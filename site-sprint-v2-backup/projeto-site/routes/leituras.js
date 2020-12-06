var express = require('express');
const db = require('./config');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Leitura = require('../models').Leitura;

router.get('/dadosMemoria', (request, response) => {
    var sql = `select top(5) memoriaUsada, memoriaTotal, FORMAT(dataHora,'dd/MM/yyyy HH:mm') as dataHora from DadosGerados order by idDados desc;`;
    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });
});

router.get('/dadosCpu', (request, response) => {
    var sql = `select top(5) porcentagemCPU, FORMAT(dataHora,'dd/MM/yyyy HH:mm') as dataHora from DadosGerados order by idDados desc;`;
    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });
});

router.get('/dadosDisco', (request, response) => {
    var sql = `select top(5) discoUsado, discoTotal, FORMAT(dataHora,'dd/MM/yyyy HH:mm') as dataHora from DadosGerados order by idDados desc;`;
    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });
});

router.get('/donutMemoria', (request, response) => {
    // var sql = `select memoriaUsada from DadosGerados order by idDados desc;`;
    var sql = `select memoriaUsada, memoriaTotal from DadosGerados where idDados = (SELECT MAX(idDados) FROM DadosGerados);`;
    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });
});

router.get('/donutDisco', (request, response) => {
    // var sql = `select discoUsado, discoTotal from DadosGerados order by idDados desc;`;
    var sql = `select discoUsado, discoTotal from DadosGerados where idDados = (SELECT MAX(idDados) FROM DadosGerados);`;
    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });
});

router.get('/donutCPU', (request, response) => {
    // var sql = `select porcentagemCPU from DadosGerados order by idDados desc;`
    var sql = `select porcentagemCPU from DadosGerados where idDados = (SELECT MAX(idDados) FROM DadosGerados);`;
    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });
});

module.exports = router;

// /* Recuperar as últimas N leituras */
// router.get('/ultimas', function(req, res, next) {
	
// 	// quantas são as últimas leituras que quer? 8 está bom?
// 	const limite_linhas = 7;

// 	console.log(`Recuperando as últimas ${limite_linhas} leituras`);
	
// 	const instrucaoSql = `select top ${limite_linhas} 
// 						temperatura, 
// 						umidade, 
// 						momento,
// 						FORMAT(momento,'HH:mm:ss') as momento_grafico 
// 						from leitura order by id desc`;

// 	sequelize.query(instrucaoSql, {
// 		model: Leitura,
// 		mapToModel: true 
// 	  })
// 	  .then(resultado => {
// 			console.log(`Encontrados: ${resultado.length}`);
// 			res.json(resultado);
// 	  }).catch(erro => {
// 			console.error(erro);
// 			res.status(500).send(erro.message);
// 	  });
// });


// // tempo real (último valor de cada leitura)
// router.get('/tempo-real', function (req, res, next) {
	
// 	console.log(`Recuperando a última leitura`);

// 	const instrucaoSql = `select top 1 temperatura, umidade, FORMAT(momento,'HH:mm:ss') as momento_grafico  
// 						from leitura order by id desc`;

// 	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
// 		.then(resultado => {
// 			res.json(resultado[0]);
// 		}).catch(erro => {
// 			console.error(erro);
// 			res.status(500).send(erro.message);
// 		});
  
// });


// // estatísticas (max, min, média, mediana, quartis etc)
// router.get('/estatisticas', function (req, res, next) {
	
// 	console.log(`Recuperando as estatísticas atuais`);

// 	const instrucaoSql = `select 
// 							max(temperatura) as temp_maxima, 
// 							min(temperatura) as temp_minima, 
// 							avg(temperatura) as temp_media,
// 							max(umidade) as umidade_maxima, 
// 							min(umidade) as umidade_minima, 
// 							avg(umidade) as umidade_media 
// 						from leitura`;

// 	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
// 		.then(resultado => {
// 			res.json(resultado[0]);
// 		}).catch(erro => {
// 			console.error(erro);
// 			res.status(500).send(erro.message);
// 		});
// });
