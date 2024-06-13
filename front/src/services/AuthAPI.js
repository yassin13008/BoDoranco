import axios from "axios";
import jwtDecode from "jwt-decode";
import { API_URL } from "../config";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const setAxiosToken = (token) => {
    axios.defaults.headers["Authorization"] = "Bearer " + token;
};

const tryLogin = async (email, password) => {
    const params = {
        email,
        password,
    };
    try {
        const response = await axios.post(`${API_URL}/auths/login`, params, {
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
        });
        if (response.data.hasError) {
            toast.error(response.data.errorString);
            logout();
            return false;
        }
        const token = response.data.token;
        window.localStorage.setItem("authToken", token);
        setAxiosToken(token);
        return true;
    } catch (err) {
        console.error("/auths/login error: ", err);
        toast.error(
            "Une erreur est survenue, veuillez réésayer ultérieurement."
        );
        return false;
    }
};

const logout = () => {
    window.localStorage.removeItem("authToken");
    delete axios.defaults.headers["Authorization"];
};

const isAuthenticated = () => {
    const token = window.localStorage.getItem("authToken");
    if (!token || token === "undefined") {
        logout();
        return false;
    }
    const tokenDecoded = jwtDecode(token);
    if (tokenDecoded.exp * 1000 <= new Date().getTime()) {
        logout();
        return false;
    }
    return true;
};

const initAxios = () => {
    const token = window.localStorage.getItem("authToken");
    if (token && token !== "undefined") {
        const tokenDecoded = jwtDecode(token);
        if (tokenDecoded.exp * 1000 > new Date().getTime()) {
            setAxiosToken(token);
        }
    }
};

const getLoggedUserInfos = () => {
    const token = window.localStorage.getItem("authToken");
    if (!token || token === "undefined") {
        return null;
    }
    const tokenDecoded = jwtDecode(token);
    return tokenDecoded.userInfos;
};

const AuthAPI = {
    tryLogin,
    logout,
    isAuthenticated,
    initAxios,
    getLoggedUserInfos,
};

export default AuthAPI;
