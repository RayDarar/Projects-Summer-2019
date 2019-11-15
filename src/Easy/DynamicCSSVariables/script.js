const root = document.documentElement;

function changeValue(id, value) {
    const suf = (id != 'color' ? 'px' : '');
    root.style.setProperty("--" + id, value + suf);
}

