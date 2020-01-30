require("dotenv").config();

const expect = require("chai").expect;

describe("environment", () => {
  it("must have PORT variable defined", () => {
    expect(process.env.PORT).not.to.be.equal(undefined);
  });
  it("must have secret key defined", () => {
    expect(process.env.SECRET_KEY).not.to.be.equal(undefined);
  });
});
