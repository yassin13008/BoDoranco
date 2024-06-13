import { daysOfWeek, monthsOfYear } from "./constants";

export const formatDate = (dateStr) => {
    const date = new Date(dateStr);
    const dayOfWeek = daysOfWeek[date.getDay()];
    const dayOfMonth = date.getDate().toString().padStart(2, "0");
    const month = monthsOfYear[date.getMonth()];
    const time = date.toLocaleTimeString([], {
        hour: "2-digit",
        minute: "2-digit",
    });
    return `${dayOfWeek} ${dayOfMonth} ${month} à ${time}`;
};
