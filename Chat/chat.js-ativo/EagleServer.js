//How to make a meme server courtesy of RhymBil
var express = require("express"); 
var app = express();
var server = require("http").createServer(app);
var io = require("socket.io").listen(server);
//setting the required variables

usuarios = []; //users array
usersConnections = []; //connections array

server.listen(process.env.PORT || 3000);  // It will run on localhost:(any number)
console.log("Servidor executando...");

app.get("/", function(req, res){
	res.sendFile(__dirname + "/index.html"); //links to html file CHANGE /index.html to you actually html file
	
});
	
io.sockets.on("connection", function(socket){
	//connection stuff
	usersConnections.push(socket);
	console.log("usuarios connected: %s", usersConnections.length);
	
	// disconnection stuff
	socket.on("disconnect", function(data){
		
		usuarios.splice(usuarios.indexOf(socket.username), 1); //accessing the array usuarios
		
		
	usersConnections.splice(usersConnections.indexOf(socket),1);
	console.log("usuarios disconnected: Carlos ");
	});
	
	//send dem proEagle messages
	socket.on("enviar nova message", function(data){ 
		console.log(data);// shows what the usuarios typed in console
		io.sockets.emit("new message", {msg: data});
	});
});
