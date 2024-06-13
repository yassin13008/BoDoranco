export const checkStringValidFormat = (data, regex) => {
    return regex.test(data);
}
export const formatedNameString = (inputString) => {
    return inputString.charAt(0).toUpperCase() + inputString.slice(1).toLowerCase();
}

export const formatedDate = (inputString) => {
    return new Date(`${inputString.split('/')[2]}-${inputString.split('/')[1]}-${inputString.split('/')[0]}`).toISOString().slice(0, 10);
}

const ValidationServices = {
    checkStringValidFormat,
    formatedDate,
    formatedNameString
};

export default ValidationServices;