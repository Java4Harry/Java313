let array = new Array("2.jpg", "3.jpg", "4.jpg");
document.write("<div style='display:flex; justify-content: space-around; width: 560px; margin: 200px auto 20px;'>");
for (let i=0; i <array.length;i++){
    document.write("<div style='border: 1px solid black; padding: 5px 5px 1px;'><img id='picture" + i + "' src='images/" + array[i] + "'></div>");  
}
document.write("</div>");
document.write("<div style='width: 560px; margin: 0 auto; text-align: center;'><b>Поменять</b> <input type='text' size='3' name='from'> <b>на</b> <input type='text' size='3' name='to'></div>");
document.write("<div style='width: 560px; margin: 10px auto;text-align: center;'><input type='button' name='change' value='поменять'></div>");

document.querySelector("input[type='button']").addEventListener("click", changePicture);

function changePicture(){
    let inputFrom = document.querySelector("input[name='from']").value;
    let inputTo = document.querySelector("input[name='to']").value;
	    if (inputFrom <=0 || inputFrom > 3 || inputTo <=0 || inputTo > 3) {
		alert("Введите значения от 1 до " + array.length);
		return;
	    }
    let deleted = array[inputFrom - 1];
    array.splice(inputFrom - 1, 1, array[inputTo - 1]);
    array.splice(inputTo - 1, 1, deleted);
    for (let i=0; i <array.length; i++) {
	let changhedPictures = document.querySelector("#picture" + i);
    changhedPictures.src = "images/" + array[i];
}
}