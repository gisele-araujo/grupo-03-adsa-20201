
// $(function(){
// var socket = io.connect();  //connects to socket
// var $messageForm = $("#messageForm"); //ref to the div message form
// var $messageInput = $("#messageInput"); //ref to input box with id message
// var $chat = $("#chat"); //ref to div chat
// var test = $messageInput.val("");

// $messageForm.submit(function(e){
// e.preventDefault();
// socket.emit("send meme message", $messageInput.val());
// $messageInput.val("");


// });
// socket.on("new meme message", function(data){


// if(data.msg.length > 0){
// $chat.append('<br>'  +'<div id="circle"> ' + '<textarea id="t" readonly>' + data.msg + '</textarea>'+' </div>' + '<br>' );
// }
// });

// });

// showlog = false;
// window.setInterval(function() {
// if(showlog == false){
//   var chat = document.getElementById("chat");
//   chat.scrollTop = chat.scrollHeight;
//   }
// }, 4);

// function showl(){
// showlog = true;

// }
// function hidel(){
// var chat = document.getElementById("chat");
//   chat.scrollTop = chat.scrollHeight;
// showlog = false;
// }

