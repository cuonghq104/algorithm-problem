/* https://leetcode.com/problems/pascals-triangle/ */
var generate = function(numRows) {
    let result = [];
    if (numRows === 0)
        return result;

    result.push([1]);
    for (let i = 1; i < numRows; i += 1) {
        let prevLayer = result[i - 1];

        let currentLayer = [];
        for (let j = 0; j <= i; j += 1) {
            let leftIdx = j - 1;
            let rightIdx = j;

            let leftVal = (leftIdx < 0) ? 0 : prevLayer[leftIdx];
            let rightVal = (rightIdx === i) ? 0 : prevLayer[rightIdx];

            currentLayer.push(leftVal + rightVal);
        }
        result.push(currentLayer);
    }
    return result;
};