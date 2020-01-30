require("dotenv").config();

const expect = require("chai").expect;

describe("environment", () => {
  it("must have PORT variable defined", () => {
    expect(process.env.PORT).not.to.be.equal(undefined);
  });
});
