let count = 1;
let score = 0;
let selection = 0;
let correctAnswer = 0;
let y = -1;
let z = -1;

let endDisplay = document.querySelectorAll('.show-hide');
let countDisplay = document.querySelector('.currentProblem');
let scoreDisplay = document.querySelector('.currentScore');
let buttonStartOver = document.getElementById('btnStartOver');

document.addEventListener('DOMContentLoaded', () => {

    createMathProblem();
    const listElements = document.querySelectorAll('li');    
        listElements.forEach(item => {
        item.addEventListener('click', (event) => {
            selection = item.innerText
            isCorrect();
        });
}); 
});

buttonStartOver.addEventListener('click', (event) => {
    location.reload();
});

function isCorrect(){
    if (selection == correctAnswer && count < 10){
        score++;
        createMathProblem();
        count++;
        scoreDisplay.innerText = score;
        countDisplay.innerText = count;
    }else if (count < 10){
        createMathProblem();
        count++;
        countDisplay.innerText = count;
    } else if (count == 10){
    
        for(let i = 0; i < endDisplay.length; i++) {
            endDisplay[i].classList.add('hidden');
        }
        // pro.classList.add(' hidden');
        // endScreen.classList.add(' hidden');
        // endScreen.classList.add(' hidden');
    }
    else{
        createMathProblem();
        count++;
        countDisplay.innerText = count;
    }
}


 /* Utility function to shuffle the items in an array @param {object} arr */
function shuffleArrayFunc(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
  }

 /* Utility function to generate a random number based on max @param {number} max */
function getRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max));
  }

function getRandomNumberBig(max) {
    x = Math.floor(Math.random() * Math.floor(max));
    if(x == correctAnswer || x == y || x == z){
        x = getRandomNumberBig(max);
    }
    z = y;
    y = x;
    return x;
  }

//arraySolutions[0] == correct answer
//take that value, put it into a LI element
function mapAnswerToPage(arraySolutions){
    correctAnswer = arraySolutions[0];
    let shuffleArray = shuffleArrayFunc(arraySolutions);
    let uiElement = document.getElementById('answers').children[0] //can add it to the children in ui
    shuffleArray.forEach((element, index) => {
        let liElement = uiElement.children[index];
        liElement.innerText = element;
    });
}

function createMathProblem(){
    let leftNum = getRandomNumber(10);
    let rightNum = getRandomNumber(10);
    let solution = leftNum * rightNum;
    correctAnswer == solution;
    let problemDisplay = document.querySelector('.expression')
    problemDisplay.innerText = leftNum + ' * ' + rightNum;
    let arraySolutions = [solution, getRandomNumberBig(81), getRandomNumberBig(81), getRandomNumberBig(81)];
    console.log(arraySolutions);
    mapAnswerToPage(arraySolutions);
    return correctAnswer
}


//change the problem each iteration of the while loop

// increment the counters

// we have to know what the solution value is so we can make a comparison




  
                // if (item === createMathProblem.arraySolution[0] ){
                //     score++;
                // }
            
                // if (item === correctAnswer) {
                //     score+=1;
                // }
