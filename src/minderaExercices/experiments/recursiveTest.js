let amountToPay = 230;
let moneyGiven = 572.20;
let changeToGive = moneyGiven - amountToPay;

const valuesEuros = [
    500, 200, 100, 50, 20, 10, 5, 1, 2, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01,
];

function calculateChange(remainChange, index = 0) {
	let counting;
	let currentValue = valuesEuros[index];
	//este e simplesmenete o objecto onde vou guardar
	let finalResult = {};


	console.log(`Remaining change: ${remainChange}`);
	console.log(`Current value: ${currentValue}`);

	if (remainChange === 0 || index >= valuesEuros.length) {
		console.log("correct");
		return finalResult;
	}


	if (remainChange >= currentValue) {
		counting = Math.floor(remainChange / currentValue);
		let newRemaningChange = remainChange - counting * currentValue;

		console.log(`Using ${counting} x ${currentValue} euro coins/bills`);

        //exemple {10 : 1}
        //second time {5 : 1}
        //third time based reached 0 remaning so we go back to the second call
		finalResult[currentValue] = counting;

        //recursive call with 5
        //second time recursive with 0
		let recursiveCall = calculateChange(
			newRemaningChange,
			index + 1
		);

        //para cada recursive call se nao tiver no final result entao 'push' that value to the finalresult
        for (let value in recursiveCall) {
			finalResult[value] =
                //se finalresult existir usao caso contrair uso 0 e 
                //somo a contagem o que esta no recursive call exemplo {nota de 5 quantidade = 1}
				(finalResult[value] || 0) + recursiveCall[value];
		}

	}else{
        //it skips to next current value if  it is bigger then remaningChange
        //also direct assign that new recursive call to the final result
        //otherwise the recursive call value will be discard, since we
        //neeed to accumulate the result from deeper levels of recursion
        finalResult = calculateChange(remainChange,index + 1);
    }

	return finalResult;
}
let final = calculateChange(changeToGive)
console.log(final);
