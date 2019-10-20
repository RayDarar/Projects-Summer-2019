const women = [
    {
        id: 1,
        name: "woman-name-1",
        surname: "woman-surname-1",
        age: 18,
        url: "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fmichelleking%2Ffiles%2F2019%2F05%2FVergara-Sofia-1200x1343.jpg"
    },
    {
        id: 2,
        name: "woman-name-2",
        surname: "woman-surname-3",
        age: 41,
        url: "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fbonniechiu%2Ffiles%2F2019%2F03%2FBrenda-bio-pic-1.jpg"
    },
    {
        id: 3,
        name: "woman-name-3",
        surname: "woman-surname-3",
        age: 35,
        url: "https://pbs.twimg.com/profile_images/913182378763411456/b6W6-3jv_400x400.jpg"
    }
];

const man = [
    {
        id: 1,
        name: "man-name-1",
        surname: "man-surname-1",
        age: 25,
        url: "https://c6oxm85c.cloudimg.io/cdno/n/q85/https://az617363.vo.msecnd.net/imgmodels/models/MD30001511/alessio400bbed6c271a3837f0f96a657c45e99e_thumbdf45b371c880d5f88a2af85f236c239f_thumb.jpg"
    },
    {
        id: 2,
        name: "man-name-2",
        surname: "man-surname-3",
        age: 30,
        url: "https://i.pinimg.com/originals/24/48/d1/2448d1c98e7811280d8954a8285cd488.jpg"
    },
    {
        id: 3,
        name: "man-name-3",
        surname: "man-surname-3",
        age: 15,
        url: "https://lsco.scene7.com/is/image/lsco/Levis/clothing/696530001-front-pdp.jpg?$grid_desktop_full$"
    }
];

window.onload = () => {
    const listWoman = document.getElementsByClassName("list-woman").item(0);
    const womanButton = listWoman.getElementsByTagName("h2").item(0);
    const womanList = listWoman.getElementsByClassName("inner-list").item(0);
    let womanFlag = false; // false - wrapped, true opened

    const userPhoto = document.getElementsByClassName("user-photo").item(0);
    const userId = document.getElementsByClassName("user-id").item(0);
    const userName = document.getElementsByClassName("user-name").item(0);
    const userSurname = document.getElementsByClassName("user-surname").item(0);
    const userAge = document.getElementsByClassName("user-age").item(0);

    womanButton.onclick = () => {
        if (womanFlag === false) {
            women.forEach((woman) => {
                const node = document.createElement("span");
                node.innerHTML = woman.name;
                node.onclick = () => {
                    userPhoto.src = woman.url;
                    userId.innerHTML = woman.id;
                    userName.innerHTML = woman.name;
                    userSurname.innerHTML = woman.surname;
                    userAge.innerHTML = woman.age;
                };

                womanList.appendChild(node);
            });
            womanFlag = true;
            womanButton.innerHTML = "&downarrow; Woman";
        } else {
            womanList.innerHTML = "";
            womanFlag = false;
            womanButton.innerHTML = "&rightarrow; Woman";
        }
    }

    const listMan = document.getElementsByClassName("list-man").item(0);
    const manButton = listMan.getElementsByTagName("h2").item(0);
    const manList = listMan.getElementsByClassName("inner-list").item(0);
    let manFlag = false;

    manButton.onclick = () => {
        if (manFlag === false) {
            man.forEach(man => {
                const node = document.createElement("span");
                node.innerHTML = man.name;
                node.onclick = () => {
                    userPhoto.src = man.url;
                    userId.innerHTML = man.id;
                    userName.innerHTML = man.name;
                    userSurname.innerHTML = man.surname;
                    userAge.innerHTML = man.age;
                }
                manList.appendChild(node);
            });
            manButton.innerHTML = "&downarrow; Man";
            manFlag = true;
        } else {
            manList.innerHTML = " ";
            manFlag = false;
            manButton.innerHTML = "&rightarrow; Man";
        }
    }

}
