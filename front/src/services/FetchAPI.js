import axios from "axios";
import { API_URL } from "../config";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const makeGetRequestReturningJsonOrNull = async (path) => {
    try {
        const response = await axios.get(`${API_URL}${path}`, {
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
        });
        if (response.data.hasError) {
            toast.error(response.data.errorString);
            return null;
        }
        return response.data;
    } catch (err) {
        console.error(`${path} error: `, err);
        toast.error(
            "Une erreur est survenue, veuillez réésayer ultérieurement."
        );
        return null;
    }
};

const makePostRequestReturningJsonOrNull = async (path, params) => {
    try {
        const response = await axios.post(`${API_URL}${path}`, params, {
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
        });
        if (response.data.hasError) {
            toast.error(response.data.errorString);
            return null;
        }
        if (response.data.response) return response.data.response;
        return response.data.data;
    } catch (err) {
        console.error(`${path} error: `, err);
        toast.error(
            "Une erreur est survenue, veuillez réésayer ultérieurement."
        );
        return null;
    }
};

const uploadImageReturningUrlOrNull = async (path, params) => {
    try {
        const response = await axios.post(`${API_URL}${path}`, params, {
            headers: {
                Accept: "application/json",
                "Content-Type": "multipart/form-data",
            },
            maxContentLength: 3500000,
            maxBodyLength: 3500000
        });
        if (response.data.hasError) {
            toast.error(response.data.errorString);
            return null;
        }
        return response.data.data;
    } catch (err) {
        console.error(`${path} error: `, err);
        toast.error(
            "Une erreur est survenue, veuillez réésayer ultérieurement."
        );
        return null;
    }
}

const makeFormDataPatchRequestReturningJsonOrNull = async (path, params) => {
    try {
        const response = await axios.post(`${API_URL}${path}`, params, {
            headers: {
                Accept: "application/json",
                "Content-Type": "multipart/form-data",
            },
            maxContentLength: Infinity,
            maxBodyLength: Infinity
        });
        if (response.data.hasError) {
            toast.error(response.data.errorString);
            return null;
        }
        if (response.data.response) return response.data.response;
        return response.data.data;
    } catch (err) {
        console.error(`${path} error: `, err);
        toast.error(
            "Une erreur est survenue, veuillez réésayer ultérieurement."
        );
        return null;
    }
}

const makeDeleteRequestReturningJsonOrNull = async (path) => {
    try {
        const response = await axios.delete(`${API_URL}${path}`, {
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
        });
        if (response.data.hasError) {
            toast.error(response.data.errorString);
            return null;
        }
        return response.data;
    } catch (err) {
        console.error(`${path} error: `, err);
        toast.error(
            "Une erreur est survenue, veuillez réésayer ultérieurement."
        );
        return null;
    }
};

const makePatchRequestReturningJsonOrNull = async (path, params) => {
    try {
        const response = await axios.patch(`${API_URL}${path}`, params, {
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
        });
        if (response.data.hasError) {
            toast.error(response.data.errorString);
            return null;
        }
        return response.data.response;
    } catch (err) {
        console.error(`${path} error: `, err);
        toast.error(
            "Une erreur est survenue, veuillez réésayer ultérieurement."
        );
        return null;
    }
};

const downloadFile = async (path) => {
    try {
        const response = await axios.get(`${API_URL}${path}`, {
            responseType: 'blob',
            headers: {
                Accept: 'application/pdf'
            }
        });
        const url = URL.createObjectURL(new Blob([response.data], { type: 'application/pdf' }));
        const newWindow = window.open(url);
        if (newWindow !== null) {
            newWindow.location = url;
        } else {
            toast.error("La fenêtre à été bloqué par votre navigateur");
        }
    } catch (err) {
        console.error(`Download error: `, err);
        toast.error(
            'Une erreur est survenue lors du téléchargement du fichier, veuillez réessayer ultérieurement.'
        );
    }
};

const FetchAPI = {
    makeGetRequestReturningJsonOrNull,
    makePostRequestReturningJsonOrNull,
    makeDeleteRequestReturningJsonOrNull,
    makePatchRequestReturningJsonOrNull,
    uploadImageReturningUrlOrNull, //for testing img upload
    makeFormDataPatchRequestReturningJsonOrNull,
    downloadFile,
};

export default FetchAPI;
