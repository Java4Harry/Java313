let input = +prompt("Введите пятизначное число:", "39671");
let a1 = input % 10;
let a2 = parseInt(input / 10) % 10;
let a3 = parseInt(input / 100) % 10;
let a4 = parseInt(input / 1000) % 10;
let a5 = parseInt(input / 10000) % 10;
alert("Произведение цифр: " + a1*a2*a3*a4*a5 + "\nСреднее арифметическое: " + (a1+a2+a3+a4+a5)/5);