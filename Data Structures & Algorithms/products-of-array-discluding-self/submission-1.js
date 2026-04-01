class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    productExceptSelf = function (nums) {
    let product = 1;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 0) {
            for (let j = i + 1; j < nums.length; j++) {
                product = nums[j] * product;
            }

            let zero = new Array(nums.length).fill(0);
            zero[i] = product;
            return zero;
        } else {
            product = nums[i] * product;
        }
    }

    let output = new Array(nums.length);
    for (let i = 0; i < nums.length; i++) {
        output[i] = product / nums[i];
    }

    return output;
};

}
