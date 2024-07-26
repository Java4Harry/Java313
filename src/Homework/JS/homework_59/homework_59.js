let choose = document.querySelector("input[type='button'");

choose.addEventListener("click", chooseRiddle);

function chooseRiddle(){
    alert("Отгадка: " + document.forma.riddle.value)
}